<?php

class Messages {
function getMessages(){
	$sql = "SELECT * FROM  Messages ORDER BY message_id desc";
   try {
	 $db = getDB();
	 $stmt = $db->query($sql);  
	 $users = $stmt->fetchAll(PDO::FETCH_OBJ);
	 return '{"games": ' . json_encode($users). '}';
	 
	} catch(PDOException $e) {
		
	return '{"error":{"text1":'. $e->getMessage() .'}}'; 
}
}

function postMessage(){
           
    $request = \Slim\Slim::getInstance()->request();
    $games = json_decode($request->getBody());
    
    try {
        $db = getDB();

       var_dump($games);

      $name = $games->name;
      $subject = $games->subject;
      var_dump($subject);
      $team = $games->team;
      $content = $games->content;
      $date = $games->date;

        $sql = "INSERT INTO Messages (name, subject, team, content, date) 
                     VALUES ('$name','$subject','$team','$content','$date')";

        var_dump($sql);

        $stmt = $db->query($sql);  
        return 'success';

    } catch(PDOException $e) {
        echo '{"error":{"text":'. $e->getMessage() .'}}';
    }
}
}			