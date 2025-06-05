package ru.test.HW.dz5;

class Television {
    private int channel = 1;

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Канал установлен на: " + channel);
    }

    public int getChannel() {
        return channel;
    }
}

class SetChannelCommand implements Command {
    private Television tv;
    private int channel;
    private int previousChannel;

    public SetChannelCommand(Television tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    @Override
    public void execute() {
        previousChannel = tv.getChannel();
        tv.setChannel(channel);
    }

    @Override
    public void undo() {
        tv.setChannel(previousChannel);
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        }
    }
    public void pressUndo() {
        if (command != null) {
            command.undo();
        }
    }
}


public class CommandSimpleExample {
    public static void main(String[] args) {
        Television tv = new Television();
        RemoteControl remote = new RemoteControl();

        SetChannelCommand channel2 = new SetChannelCommand(tv, 2);
        SetChannelCommand channel5 = new SetChannelCommand(tv, 5);

        remote.setCommand(channel2);
        remote.pressButton();

        remote.setCommand(channel5);
        remote.pressButton();

        remote.pressUndo();

    }
}