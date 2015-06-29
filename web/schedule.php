<?php

include 'db.php';

class Schedule {

function getSchedule($team){
	
	$sql = "SELECT * FROM oldboysdata WHERE team1= '$team' OR team2= '$team' ORDER BY game_id";
                     	
       try {
		$db = getDB();
		$stmt = $db->query($sql);  
		$users = $stmt->fetchAll(PDO::FETCH_OBJ);
		return '{"games": ' . json_encode($users). '}';
	} catch(PDOException $e) {
			
		echo '{"error":{"text1":'. $e->getMessage() .'}}'; 
	}
}

function getScheduleAll(){
	
	$sql = "SELECT * FROM oldboysdata ORDER BY game_id";
                     	
       try {
		$db = getDB();
		$stmt = $db->query($sql);  
		$users = $stmt->fetchAll(PDO::FETCH_OBJ);
		return '{"games": ' . json_encode($users). '}';
	} catch(PDOException $e) {
			
		echo '{"error":{"text1":'. $e->getMessage() .'}}'; 
	}
}

function postScheduleUpdate($id){
           
    $request = \Slim\Slim::getInstance()->request();
    $games = json_decode($request->getBody());
    
    try {
        $db = getDB();

       var_dump($games);

      $game_id = $games->game_id;
      $team1 = $games->team1;
      $team2 = $games->team2;
      $date = $games->date;
      $location = $games->location;
      $team1_score = $games->team1_score;
      $team2_score = $games->team2_score;

        $sql = "UPDATE oldboysdata 
                    SET team1= '$team1', team2 = '$team2', date =  '$date', location = '$location', 
                         team1_score = '$team1_score', team2_score = '$team2_score', updated = 'true'
                    WHERE game_id = '$id'  ";

        var_dump($sql);

        $stmt = $db->query($sql);  
        return 'success';

    } catch(PDOException $e) {
        echo '{"error":{"text":'. $e->getMessage() .'}}';
    }
}

}	