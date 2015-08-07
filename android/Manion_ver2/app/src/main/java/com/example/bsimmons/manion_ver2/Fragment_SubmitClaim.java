package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 10/07/2015.
 */
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Fragment_SubmitClaim extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_documents, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // create a new document
        PdfDocument document = new PdfDocument();

        // crate a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(100,100, 1).create();

        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);

        // draw something on the page
        View content = getActivity().findViewById(android.R.id.content);
        content.draw(page.getCanvas());

        // finish the page
        document.finishPage(page);

        // add more pages

        // write the document content
        String fullPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/created_PDF_Files";
        try
        {
            File dir = new File(fullPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            OutputStream fOut = null;
            File file = new File(fullPath, "test.pdf");
            if(file.exists())
                file.delete();
            file.createNewFile();
            fOut = new FileOutputStream(file);


        document.writeTo(fOut);

        // close the document
        fOut.flush();
        fOut.close();
        document.close();

        }
        catch (Exception e)
        {
            Log.e("saveToExternalStorage()", e.getMessage());
        }


    }


     public void openPDF(String fileLocation){

        File pdfFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ fileLocation);
        if(pdfFile.exists())
        {
            Uri path = Uri.fromFile(pdfFile);
            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
            pdfIntent.setDataAndType(path, "application/pdf");

            try
            {
                Toast.makeText(getActivity(), "Opening pdf...", Toast.LENGTH_LONG).show();
                startActivity(pdfIntent);
            }
            catch(ActivityNotFoundException e)
            {
                Toast.makeText(getActivity(), "No pdf viewer installed on device.", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getActivity(), "pdf file does not exist; did you delete it off your phone?", Toast.LENGTH_LONG).show();
        }
    }

    public void saveImageToExternalStorage(Bitmap image) {
        String fullPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/created_PDF_Files";
        try
        {
            File dir = new File(fullPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            OutputStream fOut = null;
            File file = new File(fullPath, "image.pdf");
            if(file.exists())
                file.delete();
            file.createNewFile();
            fOut = new FileOutputStream(file);
            // 100 means no compression, the lower you go, the stronger the compression
            image.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
        }
        catch (Exception e)
        {
            Log.e("saveToExternalStorage()", e.getMessage());
        }
    }

}