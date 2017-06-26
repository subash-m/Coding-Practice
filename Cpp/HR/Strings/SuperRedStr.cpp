#include <iostream>
#include <stack>

using namespace std;

string super_reduced_string(string s){
    string ans="";
    
    stack<char> answer;
    answer.push(s[0]);
    for(int i=1; i<s.size(); i++){
        if(answer.top() == s[i])
            answer.pop();
        else
            answer.push(s[i]);
        
    }
    if(answer.empty())
        return "Empty String";
    while(!answer.empty()){
        cout << ans << endl;
        ans = answer.top() + ans;
        answer.pop();
    }
    return ans;
}

int main() {
    string s;
    cin >> s;
    //cout << (s[0] == s[1]);
    string result = super_reduced_string(s);
    cout << result << endl;
    return 0;
}

