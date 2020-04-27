package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView animationView;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private static int COUNT = 20;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        animationView = view.findViewById(R.id.animation_view);
        myAdapter = new MyAdapter(COUNT);
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,
                    "alpha",1,0);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(recyclerView,
                    "alpha",0,1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(animator1,animator2);
            animatorSet.start();
            }
        }, 5000);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private int count;
        public MyAdapter(int count) {
            this.count = count;
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Context context = viewGroup.getContext();
            View itemView =View.inflate(context,R.layout.recycler_item,null);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
            myViewHolder.bind(i);
        }

        @Override
        public int getItemCount() {
            return count;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv);
            }

            public void bind(int position) {
                textView.setText("Item" + position);
            }
        }
    }
}
