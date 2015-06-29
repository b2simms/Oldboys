<?php

class Player{

function postMessageViewTime(){
           
    $request = \Slim\Slim::getInstance()->request();
    $data_sent = json_decode($request->getBody());
    
    try {
        $db = getDB();

       $date = $data_sent->date;
       $player_id = $data_sent->player_id;

        $sql = "UPDATE Player 
                    SET message_last_view_date=  '$date' 
                    WHERE player_id = '$player_id'";

        var_dump($sql);

        $stmt = $db->query($sql);  
        return 'success';

    } catch(PDOException $e) {
        echo '{"error":{"text":'. $e->getMessage() .'}}';
    }
}
}			