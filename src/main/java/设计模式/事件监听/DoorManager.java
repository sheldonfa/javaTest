package 设计模式.事件监听;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件源（event source）
 * 具体的事件源，比如说，你点击一个button，那么button就是event source，要想使button对某些事件进行响应，你就需要注册特定的listener。
 * @author fangxin
 * @date 2017/5/9.
 */
public class DoorManager
{
    // 维护事件监听器列表
    private List<IDoorListener> listeners = new ArrayList();

    // 添加事件监听器
    public void addDoorListener(IDoorListener listener)
    {
        synchronized (this)
        {
            if (listener != null && !(listeners.contains(listener)))
            {
                listeners.add(listener);
            }
        }
    }

    // 删除事件监听器
    public void removeDoorListener(IDoorListener listener)
    {
        synchronized (this)
        {
            if (listeners.contains(listener))
            {
                listeners.remove(listener);
            }
        }
    }

    // 通知事件监听器
    public void notifyDoors(DoorEvent event)
    {
        for (IDoorListener iDoorListener : listeners)
        {
            iDoorListener.dealDoorEvent(event);
        }
    }

    /**
     * 模拟开门事件
     */
    public void fireOpend() {
        if (listeners == null) {
            return;
        }
        DoorEvent event = new DoorEvent(this);
        event.setDoorState("open");

        notifyDoors(event);
    }
}
