<?php
class Scorers {

function getScorers(){
	
       $sql = "SELECT * FROM  Scorers ORDER BY goals desc, last_name";

                     	
       try {
		$db = getDB();
		$stmt = $db->query($sql);  
		$users = $stmt->fetchAll(PDO::FETCH_OBJ);
		echo '{"games": ' . json_encode($users). '}';
	} catch(PDOException $e) {
			
		echo '{"error":{"text1":'. $e->getMessage() .'}}'; 
	}
}
}