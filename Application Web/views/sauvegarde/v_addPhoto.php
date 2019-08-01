<?php require_once(PATH_VIEWS . 'header.php'); ?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS . 'alert.php'); ?>

<!--  Début de la page -->

<div class="col-xs-8 col-sm-6 col-md-4">
<h1><?= TITRE_PAGE_ADDPHOTO ?></h1>

<form class="well" action="index.php?page=addPhoto" method="post" enctype="multipart/form-data">

    <div class="form-group">
        <label><?= FORM_QUESTION_PHOTO_FICHIER ?></label>
        <input type="file" class="form-control-file" name="fichier" aria-describedby="fileHelp">
    </div>
    
    <div class="form-group" >
            <label><?= FORM_QUESTION_PHOTO_DESC ?></label>
            <textarea  class="form-control" name="desc" rows="3"></textarea>
    </div>
    
    <div class="form-group">
        <label><?= FORM_QUESTION_PHOTO_CAT ?></label>
        <select class="form-control" name="catSelected">
            <?php foreach($catList as $cat){?>
                <option value= <?= $cat -> getCatid() ?> /> <?= $cat -> getNomcat() ?>
            <?php } ?>
        </select>
    </div>
    
    <br>
    
    <button type="submit" class="btn btn-default"><?= BUTTON_ENVOYER ?></button>
    
</form>
</div>

<!--  Fin de la page -->

<!--  Pied de page -->
<?php require_once(PATH_VIEWS . 'footer.php'); 
