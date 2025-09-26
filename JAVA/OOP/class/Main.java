import java.util.Map;
import java.util.function.Supplier;

interface IPDevice{
    public void pressKey(String keyname);
}

class Mouse implements IPDevice{
    public void pressKey(String keyName)
    {
        System.out.println("Its a " + keyName);
    }
}
class Keyboard implements IPDevice{

    public void pressKey(String keyName)
    {
        System.out.println(keyName);
    }
}

class DeviceSelector{

    private static final Map<String, Supplier<IPDevice>> devices = Map.of
        (
            "mouse" , Mouse::new,
            "keyboard", Keyboard::new

        );

    private int deviceInitialized = 0;

    private DeviceSelector(){};

    
    private static class Holder
    {
        private static final DeviceSelector INSTANCE = new DeviceSelector();
    }

    public static DeviceSelector getInstance()
    {
        return Holder.INSTANCE;
    }

    public  IPDevice getIpDevice(String deviceName)
    {
        deviceInitialized++;

        return devices.getOrDefault(deviceName.toLowerCase(), Keyboard::new).get();
    }

    public int getDeviceInitializedCount()
    {
        return deviceInitialized;
    }
}
class Main{
    public static void main(String args[])
    {
        DeviceSelector deviceSelector = DeviceSelector.getInstance();
        
        IPDevice ipDevice = deviceSelector.getIpDevice("mouse");
        ipDevice.pressKey("Left Click");
        ipDevice.pressKey("Right Click");

        ipDevice = deviceSelector.getIpDevice("Keyboard");
        ipDevice.pressKey("A");

        System.out.println("Devices initialized count is :" + deviceSelector.getDeviceInitializedCount());
    }
}