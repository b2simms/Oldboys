<?php

class Login {
function getLogin($name){

       $sql = "SELECT * FROM Player WHERE player_name  =  '$name'  ";
                	
       try {
		$db = getDB();
		$stmt = $db->query($sql);  
		$users = $stmt->fetchAll(PDO::FETCH_OBJ);
		echo '{"games": ' . json_encode($users). '}';
	} catch(PDOException $e) {
			
		echo '{"error":{"text1":'. $e->getMessage() .'}}'; 
	}

}}