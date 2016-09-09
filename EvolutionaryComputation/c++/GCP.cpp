#include<iostream>
#include<vector>

using namespace std;

#define N 9 // node size
#define M N*(N-1)/4 // 密結合問題
#define m 3*N // 疎結合問題
int seed[] = {149, 151, 157, 163, 167, 173, 179, 181, 191, 193};


vector<vector<int> > init_graph();
int GCPGen(vector<vector<int> > graph, int link);
void print_graph(vector<vector<int> > graph);

// Graph Coloring Ploblem
int main(){   
  vector<vector<int> > graph = init_graph(); //matrix GCP
  int link = GCPGen(graph, M); // 密結合のリンク数  
      
  cout << "num_of_links:" << link << endl;

  return 0;
}

vector<vector<int> > init_graph(){
  vector<vector<int> > graph;

  for(int i = 0; i < N; i++){
    vector<int> tmp;
    for(int j = 0; j < N; j++){
      tmp.push_back(0);
    }
    graph.push_back(tmp);
  }

  return graph;
}

int GCPGen(vector<vector<int> > graph, int link){ // step2,3: 行列の上三角成分にランダムに1を加える
  srand(seed[0]);
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

  print_graph(graph);
  return count;
}
  
void print_graph(vector<vector<int> > graph){
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      cout << graph[i][j] << " ";
    }
    cout << endl;
  }
}
