package ru.test.HW.dz4;

class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Отправка электронной почты: " + message);
    }
}


class SMSSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Отправка SMS-сообщений: " + message);
    }
}


class SimpleMessage implements Message {
    private String content;
    private MessageSender sender;

    public SimpleMessage(String content, MessageSender sender) {
        this.content = content;
        this.sender = sender;
    }

    @Override
    public void send() {
        sender.sendMessage(content);
    }
}

public class BridgeSimpleExample {
    public static void main(String[] args) {
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SMSSender();

        Message message1 = new SimpleMessage("Привет!", emailSender);
        Message message2 = new SimpleMessage("Пока!", smsSender);

        message1.send();
        message2.send();
    }
}
