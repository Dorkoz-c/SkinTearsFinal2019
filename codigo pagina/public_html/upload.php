<?php

    //Se recibe imagen
    $img= $_REQUEST['foto'];
    $data = base64_decode($img);
    
    $randomstring = $_REQUEST['randomstring'];
    $opinion = $_REQUEST['opinion'];
    $nombre = $_REQUEST['nombre'];
    $usuario = $_REQUEST['usuario'];
    $Modelo = $_REQUEST['Modelo'];
    
    $fileTXT = fopen("images/".$randomstring.".txt", "w");
    fwrite($fileTXT, $opinion . PHP_EOL);
    fwrite($fileTXT, $usuario . PHP_EOL);
    fwrite($fileTXT, $Modelo . [1]);
    fclose($fileTXT);
    
    $file = "images/" . $randomstring . '.png';
    //$file = "images/" . $nombre . '.jpeg';
    $success = file_put_contents($file, $data);
    echo 'Foto subida!!';
?>