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
    <title>SKINTEARS</title>
  </head>
  <body>

          <h1 class="m-4 text-center">Bienvenidos a SkinTears</h1>
          <h3 class="m-4 text-center">Lista de imagenes subida, con la opinion y su autor</h3>

    <section class="container">
        <?php
        if (is_dir($dir)) {
            $files = scandir($dir);
            foreach($files as $file){
                
                if(!in_array($file,$exclude) && strpos($file, '.png')){
                    echo '<div class="row col-md-12 border border-secondary justify-content-center text-center">';
                    $textFile = str_replace('png','txt', $file);
                    $fichero = file_get_contents('images/'.$textFile, true);
                    $stringArr = explode("\n", $fichero);
                    echo '<div class="col-md-4 border"><label>NOMBRE USUARIO</label><li>'.$stringArr[1].'</li></div>';
                    
                    echo '<div class="col-md-4 border"><label>OPINIÓN</label><li>'.$stringArr[0].'</li></div>';

                    echo '<div class="col-md-4 border"><label>IMAGEN</label><li><img class="w-25" src="' . $dir . $file . '"></li></div>';
                    echo '</div>';
                    
                }
                
            }
        }?>
        
        
    </section>
    
    
   
    
    
    
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>
