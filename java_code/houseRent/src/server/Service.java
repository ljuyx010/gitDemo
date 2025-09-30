package server;

import model.House;

public class Service {
    private House[] houses;
    private int houseNums = 1; //记录当前房屋数量
    // 构造函数初始化
    public Service(int size){
        houses = new House[size]; //初始化确定数组的长度
        //测试数据
        houses[0] = new House(1, "张三", "北京市海淀区", "13800000000", 1000, "未出租");

    }

    //list方法，返回houses数组
    public House[] list(){
        return houses;
    }
    //新增房屋
    public boolean add(House house){
        //当房屋数量等于数组长度时，已满就扩容，把新房屋添加到数组最后
        if(houseNums == houses.length){
            House[] newHouse = new House[houseNums+1];
            for (int i = 0; i <= houseNums; i++) {
                if(i < houses.length){
                    newHouse[i] = houses[i];
                }else{
                    //当i等于houseNums时，把新房屋添加到数组最后
                    newHouse[i] = house;
                    house.setId(++i); //设置房屋id
                }
            }
            //把新数组赋值给houses完成扩容
            houses = newHouse;
            return true;
        }else{
            if (houses[houseNums] == null) {
                houses[houseNums++] = house;
                house.setId(houseNums); //设置房屋id
                return true;
            }
        }
        return false;
    }

    //根据id查找房屋
    public House find(int id){
        for (int i = 0; i < houseNums; i++) {
            if (houses[i].getId() == id) {
                return houses[i];
            }
        }
        return null;
    }

    //删除房屋
    public boolean delete(int id){
        //遍历数组，找到要删除的房屋
        for (int i = 0; i < houseNums; i++) {
            if (houses[i].getId() == id) {
                //将该房屋后面的房屋前移一位
                for (int j = i; j < houseNums - 1; j++) {
                    houses[j] = houses[j + 1];
                }
                //将最后一个房屋设为null
                //houses[houseNums - 1] = null;
                //houseNums--; //房屋数量减一
                //上面两句可以合并到一起如下：（前减减，先减后赋值）
                houses[--houseNums ] = null;
                return true;
            }
        }
        return false;
    }
}
