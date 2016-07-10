#include<stdio.h>
#include<stdlib.h>

#define N 9 // node size
#define M N*(N-1)/4 // 密結合問題
#define m 3*N // 疎結合問題
#define seed 149 // {149, 151, 157, 163, 167, 173, 179, 181, 191, 193}

void init_graph(int graph[][N]);
void CSVWrite(char *output, int graph[][N]);
int GCPGen(int graph[][N], int link);
void print_graph(int graph[][N]);

// Graph Coloring Ploblem
int main(){   
  int matM[N][N]; // 密結合問題を考えるときの行列
  int matm[N][N]; // 疎結合問題を考えるときの行列
  
  init_graph(matM);
  init_graph(matm);

  int linkM = GCPGen(matM, M); // 密結合のリンク数  
  int linkm = GCPGen(matm, m); // 疎結合のリンク数
    
  // CSVWrite("matM.csv", matM);
  // CSVWrite("matm.csv", matm);
  
  printf("密結合問題を考えたときのリンク数は%dです\n", linkM);
  printf("疎結合問題を考えたときのリンク数は%dです\n", linkm);
  print_graph(matM);

  return 0;
}

void init_graph(int graph[][N]){ // step1: n*nの2次元配列を作成(0で初期化)
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      graph[i][j] = 0;  
    }
  }
}

int GCPGen(int graph[][N], int link){ // step2,3: 行列の上三角成分にランダムに1を加える
  srand(seed);
  int array[N * N / 3];
  int count = 0, k, r;
  
  for(int i = 0, len = N * N / 3; i < len; i++){
    array[i] = -1;
  }
  
  while(count < link){
    k = 0;
    for(int i = 0, row = N / 3; i < row; i++){ // graphとarrayを対応させる
      for(int j = N / 3; j < N; j++){
	if(graph[i][j] == 0){ // まだ要素が0のものを格納 
	  array[k] = j + i * N; 
	  k++;
	}
      }
    }
    
    for(int i = N / 3 , row = 2 * N / 3; i < row; i++){
      for(int j = 2 * N / 3; j < N; j++){
	if(graph[i][j] == 0){
	  array[k] = j + i * N;
	  k++;
	}
      }
    }
    
    r = (int)((double)k * rand() / (RAND_MAX + 1.0)); // 乱数を生成してgraph[][]の上三角成分にランダムに1を代入
    if(graph[array[r] / N][array[r] % N] != 1){
      graph[array[r] / N][array[r] % N] = 1;
      count++;
    }
  }
  return count;
}
  
void CSVWrite(char *fname, int graph[][N]){
  FILE *fo;
  
  if((fo = fopen(fname, "w")) == NULL){
    printf("File[%s] dose not open!\n", fname);
    exit(0);
  }
  
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      fprintf(fo, "%d,", graph[i][j]);
    }
    fprintf(fo, "\n");
  }  
  fclose(fo); 
}

void print_graph(int graph[][N]){
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      printf("%d ", graph[i][j]);
    }
    printf("\n");
  }
}
