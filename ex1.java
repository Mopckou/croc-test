package croc;

import java.util.ArrayList;

class formatTabl{   //����� �������������� �������
	String[] vvod;
	ArrayList<String[]> array=new ArrayList<>();
	int i,j,l; //l ��� ������������ �������
	boolean[] b;
	formatTabl(String[] vvod){
		this.vvod=vvod;
	}
	
	void raz(){ //����� ���������� �� �������
		int max,k;
		max=0;
		String[] m;
		for (i=0;i<vvod.length;i++){ //���� �� ���������� ������ �� ������ � ���������� � �����
			if (vvod[i]!=null)	{
				vvod[i]=vvod[i].substring(1); // ���������� ������ ��� ������� �����������
				array.add(vvod[i].split("\\|"));// ���������� � ����� � ���������� �� �������
			}
		}
		
		for (i=0;i<array.size();i++){
			if (array.get(i).length>max){
				max=array.get(i).length;
			}
			System.out.println("kek");
			System.out.println(max);
			System.out.println(array.get(i).length);
		}
		System.out.println(max);
		for (i=0;i<array.size();i++){
			if (array.get(i).length<max){
				m=new String[max];
				for(k=0;k<array.get(i).length;k++){
					m[k]=array.get(i)[k];
				}
				array.set(i,m);
			}
		}System.out.println("_______________________________________________");
		System.out.println(array.size());
		
		b=new boolean[array.get(0).length];
		for (j=0;j<array.get(0).length;j++){
			b[j]=true; //���� ��������� ������ ������� �� ���
		for (i=0;i<array.size();i++){ //��� ������ ������� �������
			if (array.get(i)[j]==null || array.get(i)[j].isEmpty()){
				
			} else {
				b[j]=false;
			}
		}
		System.out.println(b[j] +" "+j);
		}
		l=0;
		for (i=0;i<b.length;i++){ //��� ������ �� ������� ����� ����� �� ��������
			if (b[i]==false){
			l++;	
			}
		}
		System.out.println(l);
		System.out.println("________________________");
		
		
		for (i=0;i<array.size();i++){ 
			for(j=0;j<array.get(0).length;j++){
				System.out.println(array.get(i)[j]);
			}
		}
		for (i=0;i<array.size();i++){ //���� ��� ������ �������
			m=new String[l];
			k=0;
			for(j=0;j<array.get(0).length;j++){
				if (b[j]==false){
					m[k]=array.get(i)[j];
					k++;
				}
			}
			array.set(i, m);
		} 
	}
	

	
	void up(){ //����� ������� �������
		int g;
		String per=""; //������������������ ������
		for (i=0;i<array.size();i++){
			for(j=0;j<array.get(i).length;j++){
				if(array.get(i)[j]==null){
					array.get(i)[j]=" ";
					array.get(i)[j]=array.get(i)[j].trim();
				}
				array.get(i)[j]=array.get(i)[j].trim(); // ������� ������� � ������ � � �����
				for (g=0;g<array.get(i)[j].length();g++){ //���� �� ������ � ���� ������
					
					if(array.get(i)[j].charAt(g)==' '){ //����� �������� ������ ����� �� ������ � ���������� ������ ��� ���
						if(array.get(i)[j].charAt(g+1)==' '){
							
						}else{per=per+array.get(i)[j].charAt(g);}
					}else{per=per+array.get(i)[j].charAt(g);}
					
				}
				array.get(i)[j]=per;
				per="";
			}
		}
	}
	
	void dp(){
		j=0;i=0;
		String per="";
		int n;
		int razn;
		int [] max=new int[array.get(0).length]; //������ ��� ������ �������� �� � �������
		for (i=0;i<max.length;i++){
			max[i]=0;
		}
		
		for (j=0;j<array.get(0).length;j++){ //���� ������ ������ �������� �������� � �������
			for(i=0;i<array.size();i++){ 

				if(array.get(i)[j].length()>max[j]){
					
					max[j]=array.get(i)[j].length();
				}
			}
			
		}
		
		for (j=0;j<array.get(0).length;j++){ //���� ���������� ��������
			for(i=0;i<array.size();i++){
				
				razn=max[j]-array.get(i)[j].length();
				
				if(razn!=0){
					if(razn%2==0){//��������� �� ������� ��� ������� � ��������� �������
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
	
	void vivod(){
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
		vvod[0]="|  kof  kfjkj  fkf j      kft||kot kot||";
		vvod[1]="| ||mya ki|gfg|";
		vvod[2]="|kkkfdsfgot||myaki||";
		vvod[3]="|kkkfdsfgot||myaki||";
	//��� ������ ��������� ������ 0 �������� ������� �������������� ��������
		
		formatTabl Tabl=new formatTabl(vvod);
		
		Tabl.raz();
		Tabl.up();
		Tabl.dp();
		Tabl.vivod();
	}

}
