package croc;

import java.util.ArrayList;

class formatTabl{   //класс форматирования таблицы
	String[] vvod;
	ArrayList<String[]> array=new ArrayList<>();
	int i,j;
	formatTabl(String[] vvod){
		this.vvod=vvod;
	}
	
	void raz(){ //метод разделения на массивы
		int max,k;
		max=0;
		String[] m;
		for (i=0;i<vvod.length;i++){ //цикл по разделению строки на массив и добавление к листу
			if (vvod[i]!=null)	{
				vvod[i]=vvod[i].substring(1); // перезапись строки без первого разделителя
				array.add(vvod[i].split("\\|"));// добавление к листу и разделение на массивы
			}
		}
		
		for (i=0;i<array.size();i++){
			if (array.get(i).length>max){
				max=array.get(i).length;
			}
		}
		
		for (i=0;i<array.size();i++){
			if (array.get(i).length<max){
				m=new String[max];
				for(k=0;k<array.get(i).length;k++){
					m[k]=array.get(i)[k];
				}
				array.set(i,m);
			}
		}
	}
	

	
	void up(){ //метод убирает пробелы
		int g;
		String per=""; //перезаписывающаяся строка
		for (i=0;i<array.size();i++){
			for(j=0;j<array.get(i).length;j++){
				if(array.get(i)[j]==null){
					array.get(i)[j]=" ";
					array.get(i)[j]=array.get(i)[j].trim();
				}
				array.get(i)[j]=array.get(i)[j].trim(); //убирает пробелы в начале и в конце
				for (g=0;g<array.get(i)[j].length();g++){ //цикл по строке в итой ячейке
					
					if(array.get(i)[j].charAt(g)==' '){ //циклы проверки каждой буквы на пробел и перезапись строки без них
						if(array.get(i)[j].charAt(g+1)==' '){
							
						}else{per=per+array.get(i)[j].charAt(g);}
					}else{per=per+array.get(i)[j].charAt(g);}
					
				}
				array.get(i)[j]=per;
				per="";
			}
		}
	}
	
	void dp(){ //метод выравниет столбец по самой большой строке
		j=0;i=0;
		String per="";
		int n;
		int razn;
		int [] max=new int[array.get(0).length]; 
		for (i=0;i<max.length;i++){
			max[i]=0;
		}
		
		for (j=0;j<array.get(0).length;j++){ //цикл поиска самого большого элемента в столбце
			for(i=0;i<array.size();i++){ 

				if(array.get(i)[j].length()>max[j]){
					
					max[j]=array.get(i)[j].length();
				}
			}
			
		}
		
		for (j=0;j<array.get(0).length;j++){ //цикл добавления пробелов
			for(i=0;i<array.size();i++){
				
				razn=max[j]-array.get(i)[j].length();
				
				if(razn!=0){
					if(razn%2==0){ //проверяем на деление без остатка и добавляем пробелы
						for(n=0;n<razn/2;n++){
						per=per+" ";	
						}
						per=per+array.get(i)[j].substring(0);
						for(n=0;n<razn/2;n++){
							per=per+" ";
						}
						array.get(i)[j]=per;	
						per="";
					} else {
						for (n=0;n<(razn-1)/2;n++){
							per=per+" ";
						}
						per=per+array.get(i)[j].substring(0);
						for(n=0;n<((razn-1)/2)+1;n++){
							per=per+" ";
						}
						array.get(i)[j]=per;
						per="";
					}
				}
				
			}
			
		}
	}
	
	void vivod(){//метод форматированного вывода
		for(i=0;i<array.size();i++){
			System.out.print("|");
			for (j=0;j<array.get(i).length;j++){
				System.out.print(array.get(i)[j]+"|");
			}
			System.out.println();
		}
	}
	
}

public class ex1 { 
	
	public static void main(String[] args) {
		String[] vvod=new String[10];
		vvod[0]="| space|   wooman|home   hom1|12|";
		vvod[1]="|tom| | ma      nag er|gfg|";
		vvod[2]="|error     |3 4   5    3| c a r |3|";
		vvod[3]="| |//|| |";
		
		formatTabl Tabl=new formatTabl(vvod);
		
		Tabl.raz();
		Tabl.up();
		Tabl.dp();
		Tabl.vivod();
	}

}
