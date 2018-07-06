<?php
include('functions.php');

$Nombres = $_POST['Nombres'];

var_dump($Nombres);


if($resultset=getSQLResultSet("SELECT Nombres, libretavirtual.FechaInfusion FROM `usuario`
 INNER JOIN `libretavirtual`
 ON usuario.idUsuario = libretavirtual.idUsuario WHERE usuario.NombreApellido = '".$Nombres."'")){	 
	while ($row = $resultset->fetch_array(MYSQLI_NUM)){
		echo json_encode($row);
	}
}
?>


