package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 10/07/2015.
 */
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Fragment_Documents extends Fragment {

    private PopupWindow popupWindow;

    private PopupWindow popupWindow1;
    private PopupWindow popupWindow2;
    private PopupWindow popupWindow3;
    private PopupWindow popupWindow4;
    private PopupWindow popupWindow5;

    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int FIVE = 5;

    private boolean isViewSelectedAlready = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_documents, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        RelativeLayout r1 = (RelativeLayout) getView().findViewById(R.id.pdf_doc1);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String docInfo = "This booklet contains general information about your group insurance\n" +
                        "contract.\n" +
                        "This document does not include all contractual clauses regarding\n" +
                        "definitions, eligibility, enrolment, termination of insurance and other\n" +
                        "specifications. You may access this information by consulting the contract\n" +
                        "available from your employer. ";
                if(!isViewSelectedAlready) {
                    isViewSelectedAlready = true;
                    openPopupWindow("Employee Booklet", docInfo, "780 KB", "14 Aug 2014", "/Manion_Employee_Booklet.pdf", ONE);
                }

            }
        });
        RelativeLayout r2 = (RelativeLayout) getView().findViewById(R.id.pdf_doc2);
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String docInfo = "This Plan provides extensive coverage for many services rendered outside of the your province of residence. "+
                        "It is important to note that such expenses are covered provided that they are unexpected and of an emergency nature.";
                if(!isViewSelectedAlready) {
                    isViewSelectedAlready = true;
                    openPopupWindow("Out of Country", docInfo, "780 KB", "03 May 2014", "/Manion_OutOfCountry.pdf", TWO);
                }
            }
        });
        RelativeLayout r3 = (RelativeLayout) getView().findViewById(R.id.pdf_doc3);
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String docInfo = "Health claim form - Submit";
                if(!isViewSelectedAlready) {
                    isViewSelectedAlready = true;
                    openPopupWindow("Health Claim Form", docInfo, "32.3 KB", "11 Jun 2014", "/Manion_HealthClaimForm.pdf", THREE);
                }
            }
        });
        RelativeLayout r4 = (RelativeLayout) getView().findViewById(R.id.pdf_doc4);
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String docInfo = "Dental claim form - Submit";
                if(!isViewSelectedAlready) {
                    isViewSelectedAlready = true;
                    openPopupWindow("Dental Claim Form", docInfo, "75.9 KB", "18 Oct 2013", "/Manion_DentalClaimForm.pdf", FOUR);
                }
            }
        });
        RelativeLayout r5 = (RelativeLayout) getView().findViewById(R.id.pdf_doc5);
        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String docInfo = "Terms and Conditions regarding Heritage Christian School policies and benefits that fall "
                        + "under any Class - A coverage.";
                if(!isViewSelectedAlready) {
                    isViewSelectedAlready = true;
                    openPopupWindow("Terms and Conditions", docInfo, "169 KB", "30 July 2014", "/Manion_TermsandConditions.pdf", FIVE);
                }
            }
        });

    }

    public void openPopupWindow(String docName, String docInfo, String docSize, String docDate, final String pdfFile, int windowNum) {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View popupView = layoutInflater.inflate(R.layout.popupwindow, null);

        TextView name = (TextView) popupView.findViewById(R.id.pdf_name);
        TextView info = (TextView) popupView.findViewById(R.id.pdf_info);
        TextView size = (TextView) popupView.findViewById(R.id.pdf_size);
        TextView date = (TextView) popupView.findViewById(R.id.pdf_date);

        name.setText(docName);
        info.setText(docInfo);
        size.setText(docSize);
        date.setText(docDate);

        RelativeLayout popupwindow_layout = (RelativeLayout) popupView.findViewById(R.id.popupwindow_layout);
        popupwindow_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                isViewSelectedAlready = false;
            }
        });

        Button openButton = (Button) popupView.findViewById(R.id.pdf_open);
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPDF(pdfFile);
                popupWindow.dismiss();
                isViewSelectedAlready = false;
            }
        });
        Button cancelButton = (Button) popupView.findViewById(R.id.pdf_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                isViewSelectedAlready = false;
            }
        });

        popupWindow = new PopupWindow(
                popupView,
                AbsoluteLayout.LayoutParams.WRAP_CONTENT,
                AbsoluteLayout.LayoutParams.WRAP_CONTENT,
                true);
        popupWindow.showAtLocation(getView(), Gravity.CENTER, 0, 0);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        popupWindow.update();

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


}