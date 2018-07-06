<html>
	<head>
		<meta charset="UTF-8">
	</head>
	
	<body>
		<form method="post" action="ConsultaUsuario.php">
		
		<label for="Nombres"> Nombres : </label>
			<select id="cmbNombres" name="Nombres" >
				<option value="0">Nombres: </option>
				<option value="1"> Roni </option>
			   <option value="2">toco</option>
			   <option value="3">Brian</option>
			   <?php
					
					$sql="SELECT NombreApellido FROM `usuario` ";
					$result = $conexion->query($sql); //usamos la conexion para dar un resultado a la variable
		if ($result->num_rows > 0) //si la variable tiene al menos 1 fila entonces seguimos con el codigo
			{
				$cmbNombres="";
				while ($row = $result->fetch_array(MYSQLI_ASSOC)) 
				{
					$cmbNombres .=" <option value='".$row['abbr']."'>".$row['nombre']."</option>"; //concatenamos el los options para luego ser insertado en el HTML
				}
			}
			else
			{
				echo "No hubo resultados";
			}
				//aca hay que traer todos los nombres de Usuario haciendo: SELECT NombreApellido FROM usuario y hay que ponerlos en un combobox
				//if($resultset=getSQLResultSet("SELECT NombreApellido FROM `usuario`")){	 
					//while ($row = $resultset->fetch_array(MYSQLI_NUM)){
					//echo json_encode($row);
					//}
					//}
			   ?>
			</select>
		
			
			</br>
			Buscar infusiones del: <select>
				<option value="UltimoMes">Último mes</option>
				<option value="dosMeses">Hace dos meses</option>
			    <option value="tresMeses">Hace tres meses</option><br><br>
				
				
				<input type="submit" name= "BuscarInfusiones" value="Buscar infusiones">
			</select>
			
		</form>
	</body>


</html>

	
			<?php
			
				if(isset($_POST['BuscarInfusiones']))
				{
					$Nombres = mysql_real_escape_string($_POST['Nombres']);
					echo $Nombres;
					}

			?>