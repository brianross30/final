<?php 
header( 'Content-Type: text/html;charset=utf-8' );


function ejecutarSQLCommand($commando){
 
 echo $commando;
  $mysqli = new mysqli("localhost", "root", "", "hemofiliappdb");

/* check connection */
if ($mysqli->connect_errno) {
    printf("Connect failed: %s\n", $mysqli->connect_error);
    exit();
}

if ( $mysqli->multi_query($commando)) {
     if ($resultset = $mysqli->store_result()) {
    	while ($row = $resultset->fetch_array(MYSQLI_BOTH)) {
    		
    	}
    	$resultset->free();
     }
    
   
}



$mysqli->close();
}

function ejecutarINSERT($commando)
{
	$conn = new mysqli("localhost", "root", "", "hemofiliappdb");
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

if ($conn->multi_query($commando) === TRUE) {
    echo "New records created successfully";
} else {
    echo "Error: " . $commando . "<br>" . $conn->error;
}

$conn->close();
}

function getSQLResultSet($commando){
 
  $mysqli = new mysqli("localhost", "root", "", "hemofiliappdb");
/* check connection */
if ($mysqli->connect_errno) {
    printf("Connect failed: %s\n", $mysqli->connect_error);
    exit();
}

if ( $mysqli->multi_query($commando)) {
	return $mysqli->store_result();
	
     
    
   
}



$mysqli->close();
}


?>
