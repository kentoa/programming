#include<stdio.h>
#include<stdlib.h>

#define n 9 // ノード数
#define M n*(n-1)/4 // 密結合問題
#define m 3*n // 疎結合問題
#define seed 149 // {149, 151, 157, 163, 167, 173, 179, 181, 191, 193}

// Graph Coloring Ploblem
int main(){ 
  FILE *fo;
  char *fname;
  fname = "GCP.csv";

  if((fo = fopen(fname,"w")) == NULL){
    printf("File[%s] dose not open!\n",fname);
    exit(0);
  }
 
  srand(seed);
  int i, j;
  int linkM = 0; // 密結合時のリンク数
  int linkm = 0; // 疎結合時のリンク数
  int matM[n][n]; // 密結合問題を考えるときの行列
  int matm[n][n]; // 疎結合問題を考えるときの行列
  double r; //生成した乱数　

  for(i = 0; i < n; i++){ // step1: n*nの2次元配列を作成(0で初期化)
    for(j = 0; j < n; j++){
      matM[i][j] = 0;  
      matm[i][j] = 0;
    }
  }
        
  // step2,3: 行列の上三角成分にランダムに1を加えて、密結合問題を考える
  while(linkM != M){
    for(i =0; i <n/3; i++)
      for(j =n/3; j <n; j++){
	r=(double)rand()/(RAND_MAX+1.0);
	if(linkM>=M)
	  break;
	if(r>=0.5){
	  if(matM[i][j] ==0){
	    matM[i][j]=1;
	    linkM++;
	  }
	}
      }
    
    for(i =n/3; i<2*n/3; i++)
      for(j =2*n/3; j<n; j++){
	r =(double)rand()/(RAND_MAX+1.0);
	if(linkM>=M)
	  break;
	if(r>=0.5){
	  if(matM[i][j] ==0){
	    matM[i][j]=1;
	    linkM++;
	  }
	}
      }
  }
  
  for(i =0;i<n;i++){
    for(j=0;j<n;j++)
      fprintf(fo,"%d,",matM[i][j]);
    fprintf(fo,"\n");
  }
  printf("密結合問題を考えたときのリンク数は%dです\n",linkM);
  
    
  //step2,3:行列の上三角成分にランダムに1を加えて、疎結合問題を考える
  while(linkm != m){
    for(i = 0; i < n / 3; i++)
      for(j = n/3; j < n; j++){
	r = (double)rand() / (RAND_MAX + 1.0);
	
	if(m <= linkm) break;
	
	if(0.5 <= r){
	  if(matm[i][j] == 0){
	    matm[i][j] = 1;
	    linkm++;
	  }
	}
      }
    
    for(i = n / 3; i < 2 * n / 3; i++)
      for(j = 2 * n / 3 ; j < n; j++){
	r = (double)rand() / (RAND_MAX + 1.0);
	if(linkm >= m) break;
	if(r >= 0.5){
	  if(matm[i][j] == 0){
	    matm[i][j]=1;
	    linkm++;
	  }
	}
      }
  }
  
  for(i =0;i<n;i++){
    for(j=0;j<n;j++)
      fprintf(fo,"%d,",matm[i][j]);
    fprintf(fo,"\n");
  }
  
  printf("疎結合問題を考えたときのリンク数は%dです\n",linkm);
  fclose(fo);
  
  return 0;
}
