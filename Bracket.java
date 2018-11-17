class Brackets{

  staitc boolean match(String expr){
    Stack S = new Stack();
    for(int i = 0; i < S.length(); i++){
      char c = expr.charAt(i);
      if(c == '(' || c == '[' || c == '{'){
        S.push(c);
      }
      else if(c == ')' || c == ']' || c == '}'){
        if(S.isEmpty()){
          return false;
        }
        char d = S.pop();
        if(!((c == '(' && d == ')') ||
             (c == '[' && d == ']') ||
             (c == '{' && d == '}')){
             return false;
             }
      }
    }
  }
}
