<?php
$dir = "images/";
$exclude = array( ".","..","error_log","_notes" );
?>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <!-- obtener iconos: https://fonts.google.com/icons -->
    <title>SKINTEARS</title>
  </head>
  <body>

          <h1 class="m-4 text-center">Bienvenidos a SkinTears</h1>
          <h3 class="m-4 text-center">Lista de imagenes subida, con la opinión y su autor</h3>

    <section class="container">
        <div class="row justify-content-center">
            
        </div>
        <?php
        if (is_dir($dir)) {
            $files = scandir($dir);
            $data = [];
            foreach($files as $file){
                
                if(!in_array($file,$exclude) && strpos($file, '.png')){
                    echo '';
                    
                    $textFile = str_replace('png','txt', $file);
                    $fichero = file_get_contents('images/'.$textFile, true);
                    $stringArr = explode("\n", $fichero);
                    
                    $arrayData = array(
                        'name' => $stringArr[1],
                        'answer_model' => $stringArr[3],
                        'answer_opinion' => 'Tipo 2',
                        'opinion' => $stringArr[0],
                        'img' => $dir.$file
                        );
                    array_push($data,$arrayData);
                    
                    echo
                        '<div class="row col-md-12 border border-secondary justify-content-center text-center">
                            
                            <div class="col-md-2 border">
                                <label>NOMBRE USUARIO</label>
                                <p>'.$stringArr[1].'</p>
                            </div>
                            <div class="col-md-1 border">
                                <label>RESPUESTA MODELO</label>
                                <p>'.$stringArr[3].'</p>
                            </div>
                            <div class="col-md-4 border">
                                <label>OPINIÓN</label>
                                <li>'.$stringArr[0].'</li>
                            </div>
                            <div class="col-md-2 border">
                                <label>RESPUESTA OPINIÓN</label>
                                <form action="guardar.php" method="post" name="frm">
                                    <select class="form-select" id="inputGroupSelect01" name="inputGroupSelect01">
                                        <option selected>Selecciona:</option>
                                        <option value="Piel sana">Piel sana</option>
                                        <option value="2">Tipo 1</option>
                                        <option value="3">Tipo 2</option>
                                        <option value="3">Tipo 3</option>
                                    </select>
                                    <input type="text" id="fname" name="fname">
                                    <input type=submit value=" Guardar " onclick="this.form.que_hacer.value="guardar">
                                </form>
                                
                       
                            </div>
                            <div class="col-md-3 border">
                            <label>IMAGEN</label>
                            <p><img class="w-25" src="' . $dir . $file . '"></p>
                            </div>
                        </div>';
                }
            }
            //echo json_encode($data);
        }?>
        
    </section>
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script>
        
    </script>
  </body>
</html>
