package com.comslin.ezhome.oriUi.http.bean.mainpage;

public class MainPageResultManualScene2 {
    private MainPageResultManualScene2ConditionList[] conditionList;
    private String sceneType;
    private String sceneName;
    private int sceneId;
    private String description;
    private MainPageResultManualScene2TaskList[] taskList;
    private String validTime;
    private String triggerType;
    private boolean enabled;

    public MainPageResultManualScene2ConditionList[] getConditionList() {
        return this.conditionList;
    }

    public void setConditionList(MainPageResultManualScene2ConditionList[] conditionList) {
        this.conditionList = conditionList;
    }

    public String getSceneType() {
        return this.sceneType;
    }

    public void setSceneType(String sceneType) {
        this.sceneType = sceneType;
    }

    public String getSceneName() {
        return this.sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MainPageResultManualScene2TaskList[] getTaskList() {
        return this.taskList;
    }

    public void setTaskList(MainPageResultManualScene2TaskList[] taskList) {
        this.taskList = taskList;
    }

    public String getValidTime() {
        return this.validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getTriggerType() {
        return this.triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
