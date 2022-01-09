package com.codeify.springboot01.threadAndExecutor.design_pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 保护性暂停-多对多，有多把锁
 * @author codeify
 * @since 2021/12/27 22:34
 */
@Slf4j
public class GuardedObjectTest2 {
    public static void main(String[] args) throws InterruptedException {
        Mailboxes mailboxes = new Mailboxes();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                new People().start();
            }, "线程" + i).start();
        }
        TimeUnit.SECONDS.sleep(1);
        for (Integer id : mailboxes.getIds()) {
            new Postman(id, "msg from " + id).start();
        }
    }
}

@Slf4j
class People extends Thread {
    @Override
    public void run() {
        GuardedObject guardedObject = Mailboxes.newGuardedObject();
        log.debug("wait for {}...", guardedObject.getId());
        String msg = (String) guardedObject.get(2 * 1000);
        log.debug("接收到的msg:{}", msg);
    }
}

@Slf4j
class Postman extends Thread {
    private Integer id;

    private String mail;

    public Postman(Integer id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void run() {
        GuardedObject byId = Mailboxes.getById(id);
        log.debug("send msg id:{}", id);
        byId.complete(mail);
    }
}

class Mailboxes {
    private static Hashtable<Integer, GuardedObject> table = new Hashtable<>();

    private static Integer id = 0;

    private static synchronized Integer genId() {
        return id++;
    }

    public Set<Integer> getIds() {
        return table.keySet();
    }

    public static GuardedObject getById(Integer id) {
        return table.get(id);
    }

    public static GuardedObject newGuardedObject() {
        GuardedObject guardedObject = new GuardedObject();
        guardedObject.setId(genId());
        table.put(guardedObject.getId(), guardedObject);
        return guardedObject;
    }
}
