/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return helper(nums, 0, nums.size()-1);
    }
    
    TreeNode* helper(vector<int>&nums, int lo, int hi){
        if(lo > hi) return NULL;
        int mid = lo + (hi - lo)/2;
        TreeNode* node = new TreeNode(nums[mid]);
        node->left = helper(nums, lo, mid - 1);
        node->right = helper(nums, mid+1, hi);
        return node;
    }
};