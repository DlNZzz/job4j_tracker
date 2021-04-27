package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу модели банковской системы
 * @author Dinz
 * @version 1.0
 */
public class BankService {
    /**
     * Содержит список, типа Map, пользователей с их счетами
     * {@link User} ключ
     * {@link List<Account>} значение
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя, добавляя его.
     * Если такого пользователя еще нет, добавляет его в список.
     * Иначе ничего не происходит.
     * @param user пользователь, который добавляется в очередь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход паспорт и счет, добавляет счет по пасспорту.
     * По паспорту находит пользователя с помощью метода findByPassport(passport).
     * Добавляет новый счет пользователю, если такого счета еще нет.
     * @param passport пасспорт пользователя
     * @param account счет, который добавляется пользователю
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспорт, позволяя по нему получить пользователя.
     * Перебирает список пользователей,
     * сравнивает значение пасспорта пользователя и входное значение.
     * @param passport паспорт пользователя
     * @return возвращает пользователя или null, если пользователя с таким паспортом нету
     */
    public Optional<User> findByPassport(String passport) {
        return users
                .keySet()
                .stream()
                .filter(pass -> passport.equals(pass.getPassport()))
                .findFirst();
    }

    /**
     * Метод принимает на вход паспорт и реквизит, позволяя по ним получить счет.
     * По паспорту находит пользователя с помощью метода findByPassport(passport).
     * Перебирает список счетов пользователя.
     * Сравнивает значение реквизитов счета и входное значение.
     * @param passport паспорт пользователя
     * @param requisite реквизит счета
     * @return возвращает счет или null, если счета с таким реквизитом нету
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = this.findByPassport(passport);
        return user
                .flatMap(value -> users.get(value).stream()
                .filter(acc -> acc.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * Используя паспорт и реквезит находит счет с помощью метода
     * findByRequisite(String passport, String requisite).
     * Если счета существуют и счет списания больше или
     * равен amount производится перечисление средств.
     * @param srcPassport пасспорт пользователя
     * @param srcRequisite реквезиты пользователя со счета которого переводят
     * @param destPassport пасспорт пользователя
     * @param destRequisite реквезиты пользователя на счет которого переводят
     * @param amount сумма перевода
     * @return Вернет true. Если счёт не найден или
     * не хватает денег на счёте с которого переводят, то вернет false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance()
                >= amount) {
            double temp = srcAccount.get().getBalance();
            srcAccount.get().setBalance(temp - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Просто метод main
     * @param args массив параметров
     */
    public static void main(String[] args) {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        System.out.println(bank.findByRequisite(user.getPassport(), "113").get().getBalance());
    }
}