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

    private DeviceSelector(){};

    private int operationCount = 0;
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
        operationCount++;
        if(deviceName.equalsIgnoreCase("mouse"))
        {
            return new Mouse();
        }
        return new Keyboard();
    }

    public int getOperationCount()
    {
        return operationCount;
    }
}
class Main{
    public static void main(String args[])
    {
        DeviceSelector deviceSelector = DeviceSelector.getInstance();
        
        IPDevice ipDevice = deviceSelector.getIpDevice("mouse");
        ipDevice.pressKey("Left Click");

        ipDevice = deviceSelector.getIpDevice("Keyboard");
        ipDevice.pressKey("A");

        System.out.println("Operation Count is :" + deviceSelector.getOperationCount());
    }
}