<?php include ('functions.php');
$json = '{"FechaInfusion":"Jun 15, 2018 12:00:00 AM","FechaVencimiento1":"Feb 2, 2020 12:00:00 AM","FechaVencimiento2":"Feb 2, 2020 12:00:00 AM","Lote1":"eafrf","Lote2":"eafrf","Marca":"Pfizer","Motivo":"Motivo1","Observaciones":"ewferwz","ProfilaxisDemanda":"Profilaxis","Potencia1":3423,"Potencia2":0,"Unidades":451}';

$data = json_decode($json, true);
var_dump($data);

$now = new DateTime();
//$data['FechaInfusion'] = $now->format('d-m-y');
$data['FechaInfusion'] = $now->format('Y-m-j');
//$fechainfusion=$data['FechaInfusion'];
$fechainfusion = DateTime::createFromFormat('j-M-Y', $data['FechaInfusion']);
 

$marca=$data['Marca'];
$lote1=$data['Lote1'];
$fechavencimiento1=$data['FechaVencimiento1'];
$potencia1=$data['Potencia1'];
$lote2=$data['Lote2'];
$fechavencimiento2=$data['FechaVencimiento2'];
$potencia2=$data['Potencia2'];
$unidades=$data['Unidades'];
$profilaxisdemanda=$data['ProfilaxisDemanda'];
$motivo=$data['Motivo'];
$observaciones=$data['Observaciones'];

//var_dump[$data];

ejecutarINSERT ("INSERT INTO libretavirtual (FechaInfusion, Marca, Lote1, FechaVencimiento1, Potencia1, Lote2, FechaVencimiento2, Potencia2, Unidades, ProfilaxisDemanda, Motivo, Observaciones) VALUES ('$fechainfusion', '$marca', '$lote1', '$fechavencimiento1', '$potencia1', '$lote2', '$fechavencimiento2', '$potencia2', '$unidades', '$profilaxisdemanda', '$motivo', '$observaciones')");
?>