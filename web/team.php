<?php
class Team {
function getTeam(){

	$sql = "SELECT DISTINCT team1  FROM  oldboysdata";
                     	
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