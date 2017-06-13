package 设计模式.事件监听;

import java.util.EventObject;

/**
 * 事件对象（event object）
 * 一般继承自java.util.EventObject类，封装了事件源对象以及与事件相关的信息。它是在事件源和事件监听器之间传递信息的。
 */
public class DoorEvent extends EventObject
{
    private String doorState = "";	// 表示门的状态，有“开”和“关”两种
    public DoorEvent(Object source)
    {
        super(source);
    }

    public void setDoorState(String doorState)
    {
        this.doorState = doorState;
    }

    public String getDoorState()
    {
        return this.doorState;
    }
}
