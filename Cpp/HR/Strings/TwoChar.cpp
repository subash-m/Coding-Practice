#include <iostream>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <climits>

using namespace std;

void insertMap(unordered_map<char, int> &map, char ch){
    unordered_map<char, int>::iterator it;
    it = map.find(ch);
    if(it == map.end()){
        map.insert(make_pair(ch, 1));
    }else{
        it->second++;
    }
}

bool checkPattern(string s, char &ch){
    
    for(int i(1); i<s.size(); i++){
        if(s[i] == s[i-1]){
            ch = s[i];
            return false;
        }
    }
    return true;
}

void deleteChar(string &s, char ch){
    s.erase(remove(s.begin(), s.end(), ch), s.end());
}

void deleteRepeatChar(string &s){
    char ch = static_cast<char>(NULL);
    while(!checkPattern(s, ch)){
        deleteChar(s, ch);
    }
}

char minFreq(unordered_map<char, int> &map){
    
    int min(INT_MIN);
    char ch('\0');
    unordered_map<char, int>::iterator it;
    for(it = map.begin(); it!=map.end(); it++){
        if(min > it->second){
            min = it->second;
            ch = it->first;
        }
    }
    return ch;
}

int getChar(string s){
    unordered_map<char, int> map;
    
    for(int i(0); i<s.size(); i++){
        insertMap(map, s[i]);
    }
    if(map.size() < 2)
        return 0;
    else{
        
    }
}

int maxLen(string s){
    
    int len(0);
    
    deleteRepeatChar(s);
    len = getChar(s);
    if(len == 0)
        return 0;
    
    cout << s << endl;
    return 0;
}

int main() {
    int n;
    cin >> n;
    string s;
    cin >> s;
    int result = maxLen(s);
    cout << result << endl;
    return 0;
}
