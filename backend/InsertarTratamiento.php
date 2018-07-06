<?php include ('functions.php');

$data = json_decode(file_get_contents('php://input'), true);

$idusuario=$data['IdUsuario'];
$inhibidores=$data['Inhibidores'];
$profilaxisdemanda=$data['ProfilaxisDemanda'];
$unidades=$data['Unidades'];
$marca=$data['Marca'];
$dosis=$data['Dosis'];

ejecutarINSERT ("INSERT INTO tratamiento (IdUsuario, Inhibidores, ProfilaxisDemanda, Unidades, Marca, Dosis)
VALUES ('$idusuario','$inhibidores', '$profilaxisdemanda', '$unidades', '$marca', '$dosis')");


 ?>
 
 
 
 
