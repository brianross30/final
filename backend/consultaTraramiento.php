<?php
include('functions.php');



if($resultset=getSQLResultSet("SELECT * FROM `tratamiento`")){
	while ($row = $resultset->fetch_array(MYSQLI_NUM)){
		echo json_encode($row);
	}
}

?>


