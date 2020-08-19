package com.danielgaston.owner.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatDialogFragment;

public class CreateDialog extends AppCompatDialogFragment {
     private EditText newTodo;
     private CreateDialogListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder newActivity = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater= getActivity().getLayoutInflater();
        View activity =inflater.inflate(R.layout.activity_create,null);
        newActivity.setView(activity);


        newActivity.setTitle("Create New Activity").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        newActivity.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String todo= newTodo.getText().toString();

                listener.addToList(todo);
//                String todoItem = createTxt.getText().toString();
//                items.add(todoItem);
//                itemsAdapter.notifyItemInserted(items.size()-1);
//                createTxt.setText("");
//
//                Toast.makeText(getApplicationContext(),"Item was added" , Toast.LENGTH_SHORT).show();
//                saveItems();
            }
        });

        newTodo = activity.findViewById(R.id.createTxt);



        return newActivity.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (CreateDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException( context.toString() + " must implement Dialog Listener");
        }
    }

    public interface CreateDialogListener{
        void addToList(String items);
    }

}
