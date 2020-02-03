package com.example.chatting_project;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ChatData {
    private String NickName;
    private String Msg;

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
    public ChatData(String NickName,String Msg){
        this.NickName = NickName;
        this.Msg = Msg;
    }
    public ChatData(){
        this("default","default");
    }



}
