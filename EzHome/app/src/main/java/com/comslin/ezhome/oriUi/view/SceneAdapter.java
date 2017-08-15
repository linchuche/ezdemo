package com.comslin.ezhome.oriUi.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.comslin.ezhome.oriUi.activity.scene.SceneAutoInfoActivity;
import com.comslin.ezhome.oriUi.activity.scene.SceneManualInfoActivity;
import com.comslin.ezhome.oriUi.activity.scene.SceneLanchActivity;
import com.comslin.ezhome.oriUi.http.HttpListResultBean;
import com.comslin.ezhome.oriUi.http.ListResultCallBack;
import com.comslin.ezhome.oriUi.http.bean.scene.ChanggeSceneAble;
import com.comslin.ezhome.oriUi.http.bean.scene.Scene;
import com.comslin.ezhome.oriUi.http.function.SceneHttp;
import com.comslin.ezhome.oriUi.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by linchaoer@qq.com on 2017/8/14.
 */

public class SceneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    LayoutInflater inflater;
    private Context context;
    List<Scene> sceneList = new ArrayList<>();

    public void setSceneList(List<Scene> sceneList) {
        this.sceneList = sceneList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) context = parent.getContext();
        if (inflater == null) inflater = LayoutInflater.from(parent.getContext());
        if (viewType == typeFooter) {
            FooterViewHolder footerViewHolder = new FooterViewHolder(inflater.inflate(R.layout.scene_list_item_info_add_layout, parent, false));
            return footerViewHolder;
        }
        SceneViewHolder sceneViewHolder = new SceneViewHolder(inflater.inflate(R.layout.item_scene_list, parent, false));
        return sceneViewHolder;
    }

    int typeFooter = 1;

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return typeFooter;
        }
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FooterViewHolder) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SceneLanchActivity.class);
                    context.startActivity(intent);
                }
            });
            return;
        }
        if (holder instanceof SceneViewHolder) {
            final Scene scene = sceneList.get(position);
            String type = scene.getSceneType();
            ((SceneViewHolder) holder).imageView.setImageResource(getResBySceneType(type));
            ((SceneViewHolder) holder).name.setText(scene.getSceneName());
            ((SceneViewHolder) holder).description.setText(scene.getDescription());
            ((SceneViewHolder) holder).aSwitch.setChecked(scene.getEnabled());
            ((SceneViewHolder) holder).aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Log.d(TAG, "onCheckedChanged: " + isChecked);
                    changeAble(scene.getSceneId(), isChecked);
                }
            });
            ((SceneViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    if (Scene.MANUAL.equals(scene.getSceneType())) {
                        i = new Intent(context, SceneManualInfoActivity.class);
                    } else {
                        i = new Intent(context, SceneAutoInfoActivity.class);
                    }
                    i.putExtra("scene", scene);
                    context.startActivity(i);

                }
            });
        }

    }

    String TAG = "SceneAdapter";

    private void changeAble(int position, boolean able) {
        Scene scene = sceneList.get(position);
        if (scene.getEnabled() == able) {
            return;
        }
        ((BaseActivity) context).showProgress(true);
        SceneHttp.Companion.changeAble(new ChanggeSceneAble(scene.getSceneId())).execute(new ListResultCallBack<Scene>(Scene.class) {
            @Override
            public void onError(Call call, Exception e, int id) {
                ((BaseActivity) context).showProgress(false);
                notifyDataSetChanged();
            }

            @Override
            public void onResponse(HttpListResultBean response, int id) {
                ((BaseActivity) context).showProgress(false);
                notifyDataSetChanged();
                ToastUtil.showToast(context, response.getMsg());
            }
        });
    }

    private int getResBySceneType(String type) {
        if ("AUTO".equals(type)) {
            return R.drawable.screen_auto;
        } else if ("MANUAL".equals(type)) {
            return R.drawable.screen_manual;
        } else {
            return R.drawable.screen_semiauto;
        }
    }

    @Override
    public int getItemCount() {
        return sceneList.size();
    }

    class SceneViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView description;
        Switch aSwitch;
        View itemView;

        public SceneViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.imv_scene_state);
            name = (TextView) itemView.findViewById(R.id.tv_scene_name);
            description = (TextView) itemView.findViewById(R.id.tv_scene_description);
            aSwitch = (Switch) itemView.findViewById(R.id.swt_scene);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);

        }
    }
}
