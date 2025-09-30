package view;

import model.House;
import server.Service;
import untils.Utility;

import java.util.Scanner;

public class View {
    private boolean loop = true;
    private char key = ' ';
    private Scanner sc = new Scanner(System.in);
    private Service server = new Service(10); //设置数组的长度为10
    //显示访问列表
    public void listHouses(){
        System.out.println("===============房屋列表===============");
        System.out.println("编号\t\t姓名\t\t地址\t\t\t\t电话\t\t\t\t租金\t\t\t状态");
        House[] list = server.list(); //调用Service类的list方法，返回houses数组
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                System.out.println(list[i]);
            }
        }
        System.out.println("===============房屋列表显示完毕===============\n");
    }
    //新增房屋
    public void addHouse(){
        System.out.println("===============新增房屋===============");
        System.out.print("请输入房屋姓名：");
        String name = Utility.readString(8,false);
        System.out.print("请输入房屋地址：");
        String address = Utility.readString(10,false);
        System.out.print("请输入房屋电话：");
        String phone = Utility.readString(11,false);
        System.out.print("请输入房屋租金：");
        double rent = Utility.readDouble();
        System.out.print("请输入房屋状态（未出租/已出租）：");
        String status = Utility.readString(3,false);
        House house = new House( 0,name, address, phone, rent, status);
        if (server.add(house)) {
            System.out.println("新增房屋成功");
        } else {
            System.out.println("新增房屋失败");
        }
    }

    //删除房屋
    public void deleteHouse(){
        System.out.println("===============删除房屋===============");
        System.out.print("请输入要删除的房屋编号(0-退出)：");
        int id = Utility.readInt();
        if (id == 0) {
            System.out.println("退出删除房屋操作");
            return;
        }
        char y = Utility.readConfirmSelection();
        if (y == 'y') {
            if (server.delete(id)) {
                System.out.println("删除房屋成功");
            } else {
                System.out.println("删除房屋失败");
            }
        } else {
            System.out.println("取消删除房屋操作");
        }
    }

    //查找房屋
    public void findHouse(){
        System.out.println("===============查找房屋===============");
        System.out.print("请输入要查找的房屋编号(0-退出)：");
        int id = Utility.readInt();
        if (id == 0) {
            System.out.println("退出查找房屋操作");
            return;
        }
        House house = server.find(id);
        if (house != null) {
            System.out.println("查找房屋成功");
            System.out.println(house);
        } else {
            System.out.println("查找房屋失败");
        }
    }

    //修改房屋
    public void updateHouse(){
        System.out.println("===============修改房屋===============");
        System.out.print("请输入要修改的房屋编号(0-退出)：");
        int id = Utility.readInt();

        if (id == 0) {
            System.out.println("退出修改房屋操作");
            return;
        }
        House house = server.find(id);

        if (house != null) {
            System.out.print("请输入新的房屋姓名("+house.getName()+")：");
            String name = Utility.readString(8,true);
            System.out.print("请输入新的房屋地址("+house.getAddress()+")：");
            String address = Utility.readString(10,true);
            System.out.print("请输入新的房屋电话("+house.getPhone()+")：");
            String phone = Utility.readString(11,true);
            System.out.print("请输入新的房屋租金("+house.getRent()+")：");
            double rent = Utility.readDouble();
            System.out.print("请输入新的房屋状态("+house.getStatus()+")：");
            String status = Utility.readString(3,true);
            if (!name.equals("")) {
                //不是空串才修改
                house.setName(name);
            }
            if (!address.equals("")) {
                house.setAddress(address);
            }
            if (!phone.equals("")) {
                house.setPhone(phone);
            }
            if (rent > 0) {
                house.setRent(rent);
            }
            if (!status.equals("")) {
                house.setStatus(status);
            }
            System.out.println("修改房屋成功");
        } else {
            System.out.println("修改房屋失败");
        }
    }

    //退出确认
    public void exit(){
        char confirm = Utility.readConfirmSelection();
        if (confirm == 'y') {
            loop = false;
        } else {
            System.out.println("取消退出系统");
        }
    }
    // 显示菜单
    public void menu(){
        //循环输出菜单，直到用户选择退出系统
        do {
            System.out.println("============房屋出租系统=============");
            System.out.println("\t\t1. 新增房屋");
            System.out.println("\t\t2. 查找房屋");
            System.out.println("\t\t3. 删除房屋");
            System.out.println("\t\t4. 修改房屋");
            System.out.println("\t\t5. 房屋列表");
            System.out.println("\t\t6. 退出系统");
            System.out.println("请输入你的选择（1-6）：");
            key = sc.next().charAt(0);
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("你输入的选择有误，请重新输入");
            }
        } while (loop);
    }
}
