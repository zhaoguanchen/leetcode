package array

import "sort"

func largestPerimeter(nums []int) int {
	sort.Ints(nums)

	for i := len(nums) - 3; i >= 0; i-- {
		if nums[i]+nums[i+1] > nums[i+2] {
			return nums[i] + nums[i+1] + nums[i+2]
		}
	}

	return 0
}
