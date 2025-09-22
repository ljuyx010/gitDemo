class Migong{
	int[][] map = new int[8][8];
	int n = 0;
	
	public static void main(String[] args){
		/*
		//先创建棋盘一个9行9列的棋盘0是空位，1是障碍物
		int[][] map = new int[9][9];
		//左右两边加障碍物
		for(int i=0;i<map.length;i++){
			map[i][0] = 1;
			map[i][8] = 1;
			
		}
		//上线两边加障碍物
		for(int j=0;j<map[0].length;j++){
			map[0][j] = 1;
			map[8][j] = 1;
		}
		//加两个随机障碍物
		map[1][5] = 1;
		map[6][7] = 1;
		//目标是从1，1的位置移动到7,7的位置
		//创建对象
		Migong q = new Migong();
		q.move(map,1,1);
		//输出移动轨迹
		q.printq(map);
		*/
		// 八皇后问题（每个位置的行，列，斜线都不能有其他的皇后）
		// 创建一个8行8列的棋盘
		
		Migong h = new Migong();
		h.huanghou(0,2);
		//输出
		h.printq(h.map);
	}
	
	//移动的方法 map是棋盘，x,y 起始坐标, 棋盘0空位，1障碍物，2尝试可移动，3已尝试是死路
	public void move(int[][] qp,int x, int y){
		//设置起始位置为2
		qp[x][y] = 2;
		if(x==7 && y==7){
			// 如果到达 77则结束,并且不能超出棋盘
			return ;
		}
		//开始尝试移动到下一格，移动策略是右，下，上，左，判断当前位置是否是正确的路径
		if(qp[x][y+1]==0){
			//如果右边是0则尝试继续往右
			move(qp,x,y+1);
		}else if(qp[x+1][y]==0){
			//如果下边是0则尝试继续往下
			move(qp,x+1,y);
		}else if(qp[x-1][y]==0){
			//如果上边是0则尝试继续往上
			move(qp,x-1,y);
		}else if(qp[x][y-1]==0){
			//如果左边是0则尝试继续往左
			move(qp,x,y-1);
		}else{
			//如果当前的四边都不是0，则是死路,直接返回
			qp[x][y] = 3;
			return ;
		}
		
	} 
	
	//走皇后的方法，放置皇后的位置设为1,n为第几个皇后个数
	void huanghou(int x,int y){
		if(x == 8){
			return;
		}
		if(x == 0){
			//如果是第一个位置直接放皇后
			map[x][y] = 1;
			//并尝试下一行
			huanghou(x+1,y);
		}else{
			//如果不是第一行，则把皇后放入每个位置并判断是否冲突
			for(int i=0;i<map.length;i++){
				//判断此位置是否冲突
				if(!judge(x,i)){
					//不冲突则放置皇后并尝试放下一个皇后
					map[x][i] = 1;
					huanghou(x+1,i);
					//如果下一个皇后冲突则回溯撤回当前皇后
					map[x][i]=0;
				}
				
			}
		}
		

	}
	
	boolean judge(int x,int y){	
		System.out.println(x +","+ y +","+map[x][y]);
		//判断是否冲突
		for(int i =0;i<map.length;i++){
			
			//如果这一列有皇后
			if( map[i][y] == 1){
				return true;
			}
			// 往右下的斜线有皇后（往下的位置还没有放不用判断）
			/*if(x+i<map.length && y+i<map.length ){
				if(i!=0 && map[x+i][y+i] == 1){
					return true;
				}
			}*/
			// 往左上的斜线有皇后
			if(x-i>=0 && y-i>=0 && map[x-i][y-i] == 1){
				return true;
			}
			// 往左下的斜线有皇后（往下的位置还没有放不用判断）
			/*if(x+i<map.length && y-i>=0){
				if(i!=0 && map[x+i][y-i] == 1){
					return true;
				}
			}*/
			// 往右上的斜线有皇后
			if(x-i>=0 && y+i<map.length && map[x-i][y+i] == 1){
				return true;
			}
		}
		//System.out.println(x +","+ y +"不冲突");
		//循环完行列斜角都没有皇后则不冲突
		return false;
	}
	
	// 输出棋盘移动轨迹
	void printq(int[][] qp){
		for(int i=0;i<qp.length;i++){
			for(int j=0;j<qp[i].length;j++){
				System.out.print(qp[i][j]+" ");
			}
			System.out.println();
		}	
	}
}