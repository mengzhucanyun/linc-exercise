package simple

/**
 *  Created by linc on 2020/2/16.
 */
object Exe45 {

    @JvmStatic
    fun main(args:Array<String>){
        val i=jump(intArrayOf(2,3,1,1,4))
        println(i)
    }

    fun jump(nums: IntArray): Int {
        if (nums.size<=1)
            return 0
        var current:Int=0
        var count=0
        while (current+nums[current]<nums.size-1){
            current=findFarthestPoint(nums,current)
            count++
        }
        return count+1
    }

    //找到当前节点可达范围内，下一步能走的最远的节点
    fun findFarthestPoint(nums: IntArray,current:Int):Int{
        var max=0
        for (i in current+1 .. current+nums[current]){
            if(i+nums[i]>max+nums[max]&&nums[i]!=0)
                max=i
        }
        return max
    }
}