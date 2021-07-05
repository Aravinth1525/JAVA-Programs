import java.util.Arrays;
import java.util.Scanner;
class MeshGrid
{
double x[];
double y[];
double z[];
double grid2D[][][];
double grid3D[][][][];
public MeshGrid()
{
Scanner scan = new Scanner(System.in);
System.out.print("\n\nEnter the Size of x : ");
int xsize=scan.nextInt();
System.out.print("Enter the Size of y : ");
int ysize=scan.nextInt();
System.out.print("Enter the Size of z : ");
int zsize=scan.nextInt();
x=new double[xsize];
y=new double[ysize];
z=new double[zsize];
System.out.print("\nEnter x array : ");
for(int i=0;i<xsize;i++)
{
x[i]=scan.nextDouble();
}
System.out.print("Enter y array : ");
for(int i=0;i<ysize;i++)
{
y[i]=scan.nextDouble();
}
System.out.print("Enter z array : ");
for(int i=0;i<zsize;i++)
{
z[i]=scan.nextDouble();
}
Arrays.sort(x);
Arrays.sort(y);
Arrays.sort(z);
generate2DMeshGrid();
generate3DMeshGrid();
}
private void generate2DMeshGrid()
{
grid2D= new double[2][][];
for(int i=0;i<grid2D.length;i++)
{
grid2D[i] = new double[y.length][];
}
for(int i=0;i<y.length;i++)
{
grid2D[0][i]=x;
}
for(int i=0;i<y.length;i++)
{
grid2D[1][i]=new double[x.length];
for(int j=0;j<x.length;j++)
{
grid2D[1][i][j]=y[i];
}
}
}
void generate3DMeshGrid(){
	grid3D = new double[3][][][];
	for(int i=0;i<grid3D.length;i++){
		grid3D[i] = new double[z.length][][];
	}
	for(int i=0;i<grid3D.length;i++){
		for(int j=0;j<z.length;j++){
			grid3D[i][j] = new double[y.length][];
		}
	}
	for(int i=0;i<z.length;i++){
		grid3D[0][i] = grid2D[0];
		grid3D[1][i] = grid2D[1];
	}
	for(int i=0;i<z.length;i++){
		for(int j=0;j<y.length;j++){
			grid3D[2][i][j] = new double[x.length];
			for(int k=0;k<x.length;k++){
			grid3D[2][i][j][k] = z[i];
			}
		}
	}

}
public String toString()
{
String str ="";
str=str+"\nx=[ ";
for(int i=0;i<x.length;i++)
{
str=str+x[i]+", ";
}
str=str+"]\n";
str=str+"y=[ ";
for(int i=0;i<y.length;i++)
{
str=str+y[i]+", ";
}
str=str+"]\n";
str=str+"z=[ ";
for(int i=0;i<z.length;i++)
{
str=str+z[i]+", ";
}
str=str+"]\n";
str+="\n2D MeshGrid\n\n";
for(int i=0;i<grid2D.length;i++)
{
for(int j=0;j<grid2D[i].length;j++)
{
for(int k=0;k<grid2D[i][j].length;k++)
{
str+=grid2D[i][j][k]+"\t";
}
str+="\n";
}
str+="\n\n";
}
str+="\n3D MeshGrid\n\n";
for(int z=0;z<grid3D.length;z++)
{
for(int i=0;i<grid3D[z].length;i++)
{
for(int j=0;j<grid3D[z][i].length;j++)
{
for(int k=0;k<grid3D[z][i][j].length;k++)
{
str+=grid3D[z][i][j][k]+"\t";
}
str+="\n";
}
str+="\n\n";
}
}
return str;
}
}
class MainClass
{
public static void main(String args[])
{
System.out.print("\nAravinth - 19MIC0053");
MeshGrid mg = new MeshGrid();
System.out.println(mg);
}
}
