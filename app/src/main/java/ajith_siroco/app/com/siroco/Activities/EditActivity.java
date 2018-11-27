package ajith_siroco.app.com.siroco.Activities;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.io.IOException;
import ajith_siroco.app.com.siroco.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class EditActivity extends AppCompatActivity {

    CircleImageView circleImageView;
    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        circleImageView =(CircleImageView)findViewById(R.id.choosepic);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog();
            }
        });
    }

    private void showdialog() {
        final AlertDialog.Builder alertbuilder=new AlertDialog.Builder(this);
        View view= getLayoutInflater().inflate(R.layout.choosedialog,null);
        alertbuilder.setView(view);
        alertbuilder.setTitle("Profile Photo");
        alertDialog =alertbuilder.create();
        alertDialog.show();
        view.findViewById(R.id.gallery_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"),10);
                if(alertDialog!=null)
                {
                    alertDialog.cancel();
                }

            }
        });
        view.findViewById(R.id.take_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alertDialog!=null)
                {
                    Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,11);
                    alertDialog.cancel();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10 && resultCode==RESULT_OK && data!=null &&data.getData()!=null)
        {
            Uri uri=data.getData();
            String path=uri.getPath();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                Bitmap bitmap2=Bitmap.createBitmap(bitmap,500,500,200,500);
//                performCrop(uri);
                circleImageView.setImageBitmap(bitmap2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (requestCode==11 && resultCode==RESULT_OK && data!=null &&data.getData()!=null)
        {
            Uri uri=data.getData();
            String path=uri.getPath();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
//                Bitmap bitmap1=modifyOrientation(bitmap,path);
                Bitmap bitmap2=Bitmap.createBitmap(bitmap,500,500,200,200);
//                performCrop(uri);
                circleImageView.setImageBitmap(bitmap2);
            } catch (IOException e) {

                Log.e("Test", "onActivityResult: No bitmap" );
                e.printStackTrace();
            }
        }

        if (requestCode==12 && resultCode==RESULT_OK)
        {
            Bundle bundle=data.getExtras();
            Bitmap bitmap=bundle.getParcelable("data");
            circleImageView.setImageBitmap(bitmap);
        }
    }

    private void performCrop(Uri uri) {

Intent cropintent=new Intent("com.android.camera.action.CROP");
        //indicate image type and Uri
        cropintent.setDataAndType(uri, "image/*");
        //set crop properties
        cropintent.putExtra("crop", "true");
        //indicate aspect of desired crop
        cropintent.putExtra("aspectX", 1);
        cropintent.putExtra("aspectY", 1);
        //indicate output X and Y
        cropintent.putExtra("outputX", 256);
        cropintent.putExtra("outputY", 256);
        //retrieve data on return
        cropintent.putExtra("return-data", true);
        //start the activity - we handle returning in onActivityResult
        startActivityForResult(cropintent, 12);

    }

    public static Bitmap modifyOrientation(Bitmap bitmap, String path) throws IOException {
        ExifInterface ei = new ExifInterface(path);
//        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED);

        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return rotate(bitmap, 90);

            case ExifInterface.ORIENTATION_ROTATE_180:
                return rotate(bitmap, 180);

            case ExifInterface.ORIENTATION_ROTATE_270:
                return rotate(bitmap, 270);

            case ExifInterface.ORIENTATION_FLIP_HORIZONTAL:
                return flip(bitmap, true, false);

            case ExifInterface.ORIENTATION_FLIP_VERTICAL:
                return flip(bitmap, false, true);

            default:
                Log.e("Test", "modifyOrientation: defualt switch");
                return bitmap;
        }
    }

    public static Bitmap rotate(Bitmap bitmap, float degrees) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap flip(Bitmap bitmap, boolean horizontal, boolean vertical) {
        Matrix matrix = new Matrix();
        matrix.preScale(horizontal ? -1 : 1, vertical ? -1 : 1);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

}
