package com.tuna.anhtu.assignment.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuna.anhtu.assignment.model.User;
import com.tuna.anhtu.assignment.DAO.User_DAO;
import com.tuna.anhtu.assignment.model.EditUser;
import com.tuna.anhtu.assignment.R;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    List<User> list;
    public Activity context;
    public LayoutInflater inflater;
    User_DAO userDAO;

    public UserAdapter(Activity context, List<User> list) {
        super();
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        userDAO = new User_DAO(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewHolder {
        ImageView img;
        TextView txtName;
        TextView txtDate;
        TextView txtHome;
        TextView txtPhone;
        ImageView imgEdit, imgDelete;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_user,null);
            viewHolder.img = convertView.findViewById(R.id.img);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.tvBirthday);
            viewHolder.txtHome = (TextView) convertView.findViewById(R.id.tvHome);
            viewHolder.txtPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            viewHolder.imgDelete = (ImageView) convertView.findViewById(R.id.ivDelete);
            viewHolder.imgEdit = convertView.findViewById(R.id.ivEdit);

            viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, EditUser.class);
                    Bundle b = new Bundle();
                    b.putString("NAME", list.get(position).getmName());
                    b.putString("BIRTHDAY", list.get(position).getmDate());
                    b.putString("HOME", list.get(position).getmHome());
                    b.putString("PHONE", list.get(position).getmPhone());
                    intent.putExtras(b);
                    context.startActivity(intent);
                }
            });
            viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Message");
                    builder.setMessage("Do you want delete this item ?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            userDAO.deleteUser(list.get(position).getmName());
                            list.remove(position);
                            notifyDataSetChanged();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                }
            });

            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();
        User _entry = list.get(position);
        if (position % 3 == 0) {
            viewHolder.img.setImageResource(R.drawable.android);
        } else if (position % 3 == 1) {
            viewHolder.img.setImageResource(R.drawable.android);
        } else {
            viewHolder.img.setImageResource(R.drawable.android);
        }
        viewHolder.txtName.setText(_entry.getmName());
        viewHolder.txtPhone.setText(_entry.getmPhone());
        viewHolder.txtDate.setText(_entry.getmDate());
        viewHolder.txtHome.setText(_entry.getmHome());
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<User> items) {
        this.list = items;
        notifyDataSetChanged();
    }
}
