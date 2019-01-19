public class Findpath{

  public static void main(String[] args){
  // input numbers by command line arguments.
  //create a double array f to store the fuel depot.
  int u = Integer.parseInt(args[0]);
  int m = Integer.parseInt(args[1]);
  int n = Integer.parseInt(args[2]);
  int[][] f= new int[m][n];
  for(int i = 0; i < m; i++){
    for(int j = 0; j < n; j ++){
      f[i][j] = Integer.parseInt(args[3 + j + i * n]);
    }
  }
  //make a three demention array t to track the previous route of every element.
  int[][][] t = new int[m][n][2];
  //make a double array x to store the amount of remaining fuel at each position.
  int[][] r = new int[m][n];
  r[0][0] = f[0][0];
  t[0][0][0] = -1;
  t[0][0][1] = -1;
  //calculate the first row.
  for(int j = 1; j < n; j++){
    r[0][j] = r[0][j - 1] - u + f[0][j];
    if(r[0][j - 1] >= u){
      t[0][j][0] = 0;
      t[0][j][1] = j - 1;
    }else{
      t[0][j][0] = -1;
      t[0][j][1] = -1;
    }
  }
  //calaulate the first column.
  for(int i = 1; i < m; i++){
    r[i][0] = r[i - 1][0] - u + f[i][0];
    if(r[i - 1][0] >= u){
      t[i][0][0] = i - 1;
      t[i][0][1] = 0;
    }else{
      t[i][0][0] = -1;
      t[i][0][1] = -1;
    }
  }
  //calculate other elements.
  //r[i][j] = max{r[i-1][j], r[i][j-1]} - u + f[i][j].
  for(int i = 1; i < m; i++){
    for(int j = 1; j < n; j++){
      if((r[i - 1][j] >= u) && (r[i][j - 1] >= u)){
        if(r[i - 1][j] >= r[i][j - 1]){
          r[i][j] = r[i - 1][j] - u + f[i][j];
          t[i][j][0] = i - 1;
          t[i][j][1] = j;
        }else{
          r[i][j] = r[i][j - 1] - u + f[i][j];
          t[i][j][0] = i;
          t[i][j][1] = j - 1;
        }
      }else if((r[i - 1][j] < u) && (r[i][j - 1] < u)){
        r[i][j] = 0;
        t[i][j][0] = -1;
        t[i][j][1] = -1;
      }else{
        if(r[i - 1][j] >= u){
          r[i][j] = r[i - 1][j] - u + f[i][j];
          t[i][j][0] = i - 1;
          t[i][j][1] = j;
        }else{
          r[i][j] = r[i][j - 1] - u + f[i][j];
          t[i][j][0] = i;
          t[i][j][1] = j - 1;
        }
      }
    }
  }
  //create a double array to store the possible route.
  char[][] p = new char[m][n];
  for(int i = 0; i < m; i ++){
    for(int j = 0; j < n; j ++){
      p[i][j] = '.';
    }
  }
  if(r[m - 1][n - 1] >= 0){
    p[m - 1][n - 1] = '*';
    int x = m - 1;
    int y = n - 1;
    while(t[x][y][0] != -1){
      int xx = x;
      int yy = y;
      x = t[xx][yy][0];
      y = t[xx][yy][1];
      p[x][y] = '*';
    }
  }
  //print out the given grid.
  System.out.println("The given " + m + " x " + n + " grid is: ");
  for(int i = 0; i < m; i ++){
    for(int j = 0; j < n; j++){
      System.out.print(f[i][j] + " ");
    }
  System.out.println();
  }
  //print out the amount of fuel at the end.
  if(r[m - 1][n - 1] < 0){
    System.out.println("There is no possible route.");
  }else{
    System.out.println("The amount of fuel at the end: " + r[m - 1][n - 1]);
    //print out the route.
    System.out.println("The route is: ");
    for(int i = 0; i < m; i ++){
      for(int j = 0; j < n; j ++){
        System.out.print(p[i][j] + " ");
      }
      System.out.println();
    }
    for(int i = 0; i < m; i ++){
      for(int j = 0; j < n; j++){
        System.out.print(r[i][j] + " ");
      }
    System.out.println();
    }
    for(int i = 0; i < m; i ++){
      for(int j = 0; j < n; j++){
        System.out.print("[" + t[i][j][0] + "," + t[i][j][1] + "]");
      }
    System.out.println();
    }
  }
 }
}
