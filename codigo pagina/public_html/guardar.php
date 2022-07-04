<?php
    
    $Salame = fopen("comentarios.txt","a");
    fwrite($Salame,"-----------------\n");
    fwrite($Salame,"Tipo de Herida: ");
    fwrite($Salame,$_POST["inputGroupSelect01"]);
    fwrite($Salame,"\n");
    fwrite($Salame,"Comentario: ");
    fwrite($Salame,$_POST["fname"]);
    fwrite($Salame,"\n");
    fwrite($Salame,"-----------------\n");
    fclose($Salame);
?>