package com.mobile.yeschurch;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PictureActivity extends AppCompatActivity{
    ImageView imageToUpload, image_take_picture;
    Button button_upload_image, button_take_image;
    EditText text_image_name, text_take_picture;

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 100;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    static final int CAMERA_REQUEST = 10;
    static final int LOCATION_REQUEST = 20;
    static final int STORAGE_REQUEST = 30;
    static final int PERMISSION_CODE = 40;
    public String currentPhotoPath;

    //FirebaseStorage storage;

    //public StorageReference mStorageRef;
    public Uri uriFoto;
    public String nameFoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        imageToUpload = (ImageView) findViewById(R.id.imageToUpload);
        image_take_picture = (ImageView) findViewById(R.id.image_take_picture);

        button_upload_image = (Button) findViewById(R.id.button_upload_image);
        button_take_image = (Button) findViewById(R.id.button_take_image);

        text_image_name = (EditText) findViewById(R.id.text_image_name);
        text_take_picture = (EditText) findViewById(R.id.text_take_picture);

        //imageToUpload.setOnClickListener(this);
        //button_upload_image.setOnClickListener(this);

        button_take_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, 0);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            super.onActivityResult(requestCode, resultCode, data);
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //image_take_picture.setImageBitmap(imageBitmap);
            image_take_picture.setImageURI(uriFoto);
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File...
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            case STORAGE_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "El usuario otorgó el permiso de almacenamiento", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "No puede utilizar la funcionalidad de almacenamiento", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            case CAMERA_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "El usuario otorgó el permiso para usar la cámara", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "El usuario no permitió el uso de la cámara", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(currentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

}
