package autodiscoverheal.cache;

/**
 *   Manage Cache instance
 */
public class CacheManager {
    private static Cache cache;
    public static Cache getInstance(String identifier) {
        if (cache == null) {
            cache = new Cache(identifier);
        }
        try {
            cache.deSerialize();
        } catch (NoCacheException e) {
            cache.serializeCache();
        }
        return cache;
    }

    public static void close() {
        cache.serializeCache();
        cache = null;
    }

    public static String get(String key) throws ItemNotInCacheException, NoCacheException {
        if (cache != null) {
            return cache.get(key);
        } else {
            throw new NoCacheException("Cache has not been created.");
        }
    }
}
