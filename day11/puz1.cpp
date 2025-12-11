#include <bits/stdc++.h>
using namespace std;
unordered_map<string, vector<string>> g;
vector<string> path;
long long total = 0;
void dfs(const string &u, unordered_set<string> &seen) {
    if (u == "out") {
        total++;
        return;
    }
    if (!g.count(u)) return;
    for (const string &v : g[u]) {
        if (seen.count(v)) continue; 
        seen.insert(v);
        dfs(v, seen);
        seen.erase(v);
    }
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string line;
    while (getline(cin, line)) {
        if (line.empty()) continue;
        auto pos = line.find(':');
        if (pos == string::npos) continue;
        string name = line.substr(0, pos);
        string rest = line.substr(pos + 1);
        while (!rest.empty() && isspace(rest[0])) rest.erase(rest.begin());
        stringstream ss(rest);
        string outdev;
        while (ss >> outdev) {
            g[name].push_back(outdev);
        }
    }
    unordered_set<string> seen;
    seen.insert("you");
    dfs("you", seen);
    cout << total << "\n";
    return 0;
}
