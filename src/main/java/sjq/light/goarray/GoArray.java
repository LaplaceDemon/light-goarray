package sjq.light.goarray;

public class GoArray<T> {
    private Object[] array;
    private int offset;
    private int len;
    private int cap;
    
    private GoArray() {
    }
    
    public GoArray(int cap) {
        this.array = new Object[cap];
        this.offset = 0;
        this.len = 0;
        this.cap = cap;
    }
    
    public GoArray(T[] array) {
        this.array = array;
        this.offset = 0;
        this.len = array.length;
        this.cap = array.length;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(this.len > 0) {
            sb.append(this.get(0));
            for(int i = 1;i<len;i++) {
                sb.append(", ");
                sb.append(this.get(i));
            }
        }
        sb.append("]");
        
        return "[array=" + sb.toString() + ", len=" + len + ", cap=" + cap + "]";
    }


    @SuppressWarnings("unchecked")
    public T get(int index) {
        if(index >= this.len) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        
        int i = index + this.offset;
        return (T)(this.array[i]);
    }
    
    public void set(int index, T v) {
        if(index >= this.len) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        
        int i = index + this.offset;
        this.array[i] = v;
    }
    
    public GoArray<T> slice() {
        GoArray<T> goArray = new GoArray<>();
        goArray.array = this.array;
        goArray.len = this.len;
        goArray.cap = this.cap;
        goArray.offset = this.offset;
        
        return goArray;
    }
    
    public GoArray<T> slice(int startIndex,int endIndex) {
        GoArray<T> goArray = new GoArray<>();
        goArray.array = this.array;
        goArray.len = endIndex - startIndex;
        goArray.cap = this.cap - startIndex;
        goArray.offset = this.offset + startIndex;
        
        return goArray;
    }
    
    public GoArray<T> sliceWithStart(int startIndex) {
        return this.slice(startIndex, this.len);
    }
    
    public GoArray<T> sliceWithEnd(int endIndex) {
        return this.slice(0,endIndex);
    }
        
    public static <A> GoArray<A> append(GoArray<A> arr,A v) {
        GoArray<A> newGoArray = new GoArray<>();
        if(arr.len >= arr.cap) { // expand
            int newCap = arr.cap << 1;
            Object[] newArray = new Object[newCap];
            Object[] srcArray = arr.array;
            System.arraycopy(srcArray, arr.offset, newArray, 0, arr.cap);
            newGoArray.array = newArray;
            newGoArray.cap = newCap;
            newGoArray.offset = 0;
        } else {
            newGoArray.array = arr.array;
            newGoArray.cap = arr.cap;
            newGoArray.offset = arr.offset;
        }
        
        newGoArray.len = arr.len + 1;
        newGoArray.set(arr.len, v);
        
        return newGoArray;
    }
    
    public static <A> int len(GoArray<A> arr) {
        return arr.len;
    }

    public static <A> int cap(GoArray<A> arr) {
        return arr.cap;
    }
    
    public static <A> int copy(GoArray<A> dst,GoArray<A> src) {
        if (dst.len < src.len) {
            System.arraycopy(src.array, src.offset , dst.array, dst.offset, dst.len);
            return dst.len;
        } else {
            System.arraycopy(src.array, src.offset, dst.array, dst.offset, src.len);
            return src.len;
        }
    }
    
    public static <A> GoArray<A> make(Class<A[]> clazz,int cap) {
        Object[] array = new Object[cap];
        GoArray<A> goArray = new GoArray<>();
        goArray.array = array;
        goArray.offset = 0;
        goArray.len = 0;
        goArray.cap = cap;
        
        return goArray;
    }
    
    @SuppressWarnings("unchecked")
    public static <A> GoArray<A> make(Class<A[]> clazz,int len,int cap) {
        if(len > cap) {
            throw new IllegalArgumentException();
        }
        
        boolean isarray = clazz.isArray();
        if(!isarray) {
            throw new IllegalArgumentException();
        }
        
        Object[] array = new Object[cap];
        GoArray<A> goArray = new GoArray<>();
        goArray.array = array;
        goArray.offset = 0;
        goArray.len = len;
        
        if(clazz.isAssignableFrom(Integer[].class)) {
            for(int i = 0;i<len;i++) {
                goArray.set(i, (A)Integer.valueOf((int)0));
            }
        } else if(clazz.isAssignableFrom(Short[].class)) {
            for(int i = 0;i<len;i++) {
                goArray.set(i, (A)Short.valueOf((short)0));
            }
        } else if(clazz.isAssignableFrom(Long[].class)) {
            for(int i = 0;i<len;i++) {
                goArray.set(i, (A)Long.valueOf((long)0));
            }
        } else if(clazz.isAssignableFrom(Double[].class)) {
            for(int i = 0;i<len;i++) {
                goArray.set(i, (A)Double.valueOf((double)0));
            }
        } else if(clazz.isAssignableFrom(Float[].class)) {
            for(int i = 0;i<len;i++) {
                goArray.set(i, (A)Float.valueOf((float)0));
            }
        } else if(clazz.isAssignableFrom(Boolean[].class)) {
            for(int i = 0;i<len;i++) {
                goArray.set(i, (A)Boolean.valueOf(false));
            }
        } else if(clazz.isAssignableFrom(Character[].class)) {
            for(int i = 0;i<len;i++) {
                goArray.set(i, (A)Character.valueOf((char)0));
            }
        } else if(clazz.isAssignableFrom(Byte[].class)) {
            for(int i = 0;i<len;i++) {
                goArray.set(i,(A)Byte.valueOf((byte)0));
            }
        } else {
            for(int i = 0;i<len;i++) {
                goArray.set(i,null);
            }
        }
        
        goArray.cap = cap;
        return goArray;
    }
    
}
