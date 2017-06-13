package 设计模式.事件监听;

/**
 * 事件监听器实现
 * 实现java.util.EventListener接口,需要注册在事件源上才能被调用。它监听事件，并进行事件处理或者转发。
 * @author fangxin
 * @date 2017/5/9.
 */
public class FrontDoorListener implements IDoorListener {
    /**
     * 做具体的开门，关门动作
     * @param event
     */
    @Override
    public void dealDoorEvent(DoorEvent event){
        if (event.getDoorState()!=null && event.getDoorState().equals("open"))
        {
            System.out.println("前门打开");
        }
        else
        {
            System.out.println("前门关闭");
        }
    }
}
